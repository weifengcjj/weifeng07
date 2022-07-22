package com.spring;

import com.cjj.service.BeanDefinition;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class ApptionContexy {
    private Class configclass;
    private ConcurrentHashMap<String,Object> singletonObjects =new ConcurrentHashMap<>();//单例池
    private ConcurrentHashMap<String,BeanDefinition> beanDefinitionMap=new ConcurrentHashMap<>();
    private List<BeanPostProcessor> beanPostProcessorList=new ArrayList<>();
    public ApptionContexy(Class configclass1){
        this.configclass = configclass1;
        //解析配置类
        //CompoentScan 注解-->拿到扫描路径-->扫描-->BeanDefinition-->BeanDefinitionMao
          scan(configclass);
//        for(String name:beanDefinitionMap.keySet())
//        {
//            BeanDefinition beanDefinition=beanDefinitionMap.get(name);
//        }
        for (Map.Entry<String,BeanDefinition> entry: beanDefinitionMap.entrySet()) {
            String name=entry.getKey();
            System.out.println("name值为:"+name);
            BeanDefinition beanDefinition=entry.getValue();
            if(beanDefinition.getScope().equals("singleton"))
            {
                Object bean = createBean(name,beanDefinition);//单例bean对象
                System.out.println("bean值为："+bean);
                singletonObjects.put(name,bean);//进入单例池
            }
        }
//        for(String name:beanDefinitionMap.keySet())
//        {
//            BeanDefinition beanDefinition=beanDefinitionMap.get(name);
//            if(beanDefinition.getScope().equals("singleton")){
//                Object object=createBean(name,beanDefinition);
//                singletonObjects.put(name,object);
//            }
//        }

    }
    public Object createBean(String BeanName,BeanDefinition beanDefinition)//根据bean的定义创建对象
    {
        Class clazz = beanDefinition.getClazz();
        try {
            Object o = clazz.getDeclaredConstructor().newInstance();
            // 依赖注入
            for (Field declaredField : clazz.getDeclaredFields()) {//判断类
                if(declaredField.isAnnotationPresent(Autowired.class))//判断加了Autowired注解的字段
                {
                    //给一个属性赋值,从spring容器找值
                    Object bean = getBean(declaredField.getName());
                    //getbean传属性名字得到bean对象
                    declaredField.setAccessible(true);
                    declaredField.set(o,bean);
                }
            }
            //Aware回调
            if(o instanceof  BeanNameAware)//当前这个bean是否实现了这个接口
            {
                ((BeanNameAware) o).setBeanNameAware(BeanName);
            }
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
               Object o1 = beanPostProcessor.postProcessBeforeInitialization(o, BeanName);//调用初始化之前
            }
            //初始化
            if(o instanceof InitializingBean)
            {
                try {
                    ((InitializingBean) o).afterPropertiesSet();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                Object o2= beanPostProcessor.postProcessAftereInitialization(o, BeanName);//调用初始化之后
            }
            //BeanPostProcessor
            return o;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void scan(Class configclass) {

        if(configclass.isAnnotationPresent(ComponentScan.class))//用来判断当前类是否有此注解
        {
        }
        ComponentScan componentScan = (ComponentScan) configclass.getDeclaredAnnotation(ComponentScan.class);

        String value = componentScan.value();//扫描路径
        System.out.println(value);

        //扫描
        //bootstrap -->引导类加载器-jre/lib
        //Ext -->扩展类加载器-jre/ext/lib
        //App -->应用类加载器-classpath
        ClassLoader classLoader=ApptionContexy.class.getClassLoader();//app
        URL resource = classLoader.getResource("com/cjj/service");
        File file=new File(resource.getFile());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                String fn=f.getAbsolutePath();
                if(fn.endsWith(".class")) {

                    String classname = fn.substring(fn.indexOf("com"), fn.indexOf(".class"));
                    classname = classname.replace("\\", ".");
                    //System.out.println(classname);
                    try {
                        Class<?> clazz = classLoader.loadClass(classname);
                        if (clazz.isAnnotationPresent(Componet.class)) {
                            //..表示当前这个类是一个Bean
                            //解析类，判断当前bean是否单例，还是prototype

                            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                //当前的clazz是否实现了这个接口
                                  BeanPostProcessor  o = (BeanPostProcessor) clazz.getDeclaredConstructor().newInstance();
                                  beanPostProcessorList.add(o);
                            }

                            //BeanDefinition
                            Componet componet = clazz.getDeclaredAnnotation(Componet.class);
                            String beanName=componet.value();
                            System.out.println("componet值为："+beanName);

                            //每扫描一个就解析一个
                            BeanDefinition beanDefinition=new BeanDefinition();
                            //某一个bean的定义
                            beanDefinition.setClazz(clazz);

                            if(clazz.isAnnotationPresent(Scope.class))
                            {
                                Scope scopeAnnotation =clazz.getDeclaredAnnotation(Scope.class);
                                beanDefinition.setScope(scopeAnnotation.value());
                                //把当前用户所配的值直接设置到里面去
                            }
                            else {
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinitionMap.put(beanName,beanDefinition);
                        }
                    }
                    catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public Object getBean(String beanName)
    {
        //getbean
        if(beanDefinitionMap.containsKey(beanName))
        {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if(beanDefinition.getScope().equals("singleton"))//如果是单例的
            {
                Object o = singletonObjects.get(beanName);
                return o;
            }
            else {
                //如果是原型的 创建Bean对象
                Object bean = createBean(beanName,beanDefinition);
                return bean;
            }
        }
        else
        {
            //不存在对应Bean
            throw new NullPointerException();
        }
    }



}
