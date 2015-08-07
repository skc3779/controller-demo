# Spring 3.x Restfull Sample


## Controller ClassName 매핑방법 1번

ControllerClassNameHandlerMapping 와 Bean 을 이용해 아래와 같이 매핑하면

```xml
<bean
    class="org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping">
    <property name="caseSensitive" value="false" />
    <property name="pathPrefix" value="/one" />
</bean>

<bean class="one.controller.OneWelcomeController" />
<bean class="one.controller.HelloGuestController" />
```

웹 주소를 아래와 같은 웹접근이 가능합니다

http://localhost:8080/one/onewelcome.do
http://localhost:808/one/helloguest.do


## Controller ClassName 매핑방법 2번

ControllerClassNameHandlerMapping 와 component-scan 이용하여 Controller annotation 매핑하면
```xml
<context:component-scan base-package="two" resource-pattern="**/*.class">
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller" />
</context:component-scan>

<bean
    class="org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping">
    <property name="caseSensitive" value="false" />
    <property name="basePackage" value="two" />
    <!-- <property name="pathPrefix" value="/two" /> -->
</bean>
```

base-package 밑의 모든 controller의 메소드들을 자동으로 RequestMapping 시켜줍니다.

http://localhost:8080/controller/twowelcome/one.do
http://localhost:8080/controller/twowelcome/two.do


## Annotation-drive 매핑방법 3번

