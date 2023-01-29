# spring-basic

1. DB다중연결 세팅 data-soruce 추가로 true/false로 연결할 DB선택
2. yml 암/복호화 세팅 jasypt 사용
3. log 세팅 (log4j2)
   * slf4j  
   Simple Logging Facade For Java의 약자로써 자체적인 로킹 프레임워크가 아니고 logger 추상체로써 다른 로깅 프레임워크가 접근할 수 있도록 도와주는 추상화 계층이다. 즉, logback이나 log4j2와 같은 로킹 프레임워크의 인터페이스의 역할을 해준다. 따라서 slf4j2를 이용하면 코드를 일정하게 유지하면서 구현체의 전환을 통해 다른 로깅 프레임워크로의 전환을 쉽고 간단하게 할 수 있다
   * log4j  
   가장 오래된 로깅 프레임워크로써 Apache의 Java기반 로깅 프레임 워크이다. 콘솔 및 파일 출력의 형태로 로깅을 도와주며 xml, properties로 환경을 구성할 수 있다. 현재는 2015년 기준으로 개발이 중단되었다. log4j는 다음과 같은 구성을 가지고 있다.
   * logback  
   log4j 이후에 출시된 보다 향상되고 가장 널리 사용되고 있는 Java 로깅 프레임워크중 하나이다. slf4j의 구현체로써 동작하는 logback은 Springboot 환경의 경우는 spring-boot-starter-web안에 spring-boot-starter-logging의 logback이 기본적으로 포함되어 있어서 별다른 dependency 추가 없이 사용할 수 있다.
   * log4j2  
   가장 최신에 나온 로깅 프레임워크로써 Apache의 log4j의 다음 버전이다. logback처럼 필터링 기능과 자동 리로딩을 지원한다. logback과의 가장 큰 차이는 Multi Thread 환경에서 비동기 로거(Async Logger)의 경우 다른 로깅 프레임워크보다 처리량이 훨씬 많고, 대기 시간이 훨씬 짧다. 또한, Java8부터 도입된 람다식을 지원하고, Lazy Evalutaion을 지원한다.