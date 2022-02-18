package dev.cooeeu.demo.spring5

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration}
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.thymeleaf.spring5.SpringTemplateEngine
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver
import org.thymeleaf.spring5.view.ThymeleafViewResolver
import org.thymeleaf.templatemode.TemplateMode

import java.nio.charset.StandardCharsets

@Configuration
@EnableWebMvc
@ComponentScan(Array("dev.cooeeu.demo.spring5"))
class DemoWebConfig:

  @Autowired
  private var applicationContext: ApplicationContext = null

  @Bean
  def templateResolver: SpringResourceTemplateResolver =
    val templateResolver = SpringResourceTemplateResolver()
    templateResolver.setApplicationContext(applicationContext)
    templateResolver.setPrefix("/WEB-INF/templates/")
    templateResolver.setSuffix(".html")
    templateResolver.setTemplateMode(TemplateMode.HTML)
    templateResolver.setCacheable(true)
    templateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name())

    templateResolver

  @Bean
  def templateEngine: SpringTemplateEngine =
    val templateEngine = SpringTemplateEngine()
    templateEngine.setTemplateResolver(templateResolver)
    templateEngine.setEnableSpringELCompiler(true)

    templateEngine

  @Bean
  def viewResolver: ThymeleafViewResolver =
    val viewResolver = ThymeleafViewResolver()
    viewResolver.setTemplateEngine(templateEngine)
    viewResolver.setCharacterEncoding(StandardCharsets.UTF_8.name())

    viewResolver
