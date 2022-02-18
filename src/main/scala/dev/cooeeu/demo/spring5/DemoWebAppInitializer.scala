package dev.cooeeu.demo.spring5

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer

class DemoWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer:
  override def getRootConfigClasses: Array[Class[_]] = null

  override def getServletConfigClasses: Array[Class[_]] = Array(classOf[DemoWebConfig])

  override def getServletMappings: Array[String] = Array("/")
