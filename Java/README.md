Java8 interview question [https://www.interviewbit.com/java-8-interview-questions/]를 번역한 글입니다.

1. Java8에 새롭게 도입된 기능을 설명하라.

- lambda expression (람다 표현식)
    - 객체처럼 다룰 수 있는 함수, 공유 가능 
    
- functional interface (함수형 인터페이스)
    - single abstract method (SAM)이라고도 불림
    - 한 개의 추상 메소드를 가진 인터페이스 
     
- method reference (메소드 레퍼런스)
    - 메소드를 호출하기 위해서 함수를 파라미터로 사용
    - 람다 표현식을 더 간단하게 표현하는 방법
    
- default method (디폴트 메소드)
    - 자바8은 구현된 메서드를 포함하는 인터페이스를 정의 가능
    - 인터페이스를 구현하는 클래스는 자동으로 인터페이스에 추가된 디폴트 메서드를 상속받게 됨
    
- stream api
    - 데이터를 추상화하고, 처리하는 함수들을 제공
    - 데이터를 추상화했다는 것은 데이터의 종류에 관계없이 같은 방식으로 데이터를 처리할 수 있음을 의미함
    - 고로 코드를 재사용하기 좋음
    
- date time api
    - 기존에 java의 date 관련 api가 문제가 많았는데, 이를 개선함
    
- optional
    - 널 값을 체크할 수 있는 wrapper 클래스를 제공함
    
- nashorn, Javascript engine
    - rhino를 대체하는 자바에서 돌아가는 향상된 버전의 자바스크립트 엔진

2. java8의 장점은?
- compact, 읽기 쉽고, 재사용하기 쉬운 코드
- 보일러 플레이트 코드가 적음
    - 보일러 플레이트 코드: 최소한의 수정으로 여러 곳에서 재사용되며 반복적으로 비슷한 형태를 띄는 코드

3. 메타스페이스가 무엇인가? PermGen과 무엇이 다른가?
- java7 까지는 permGen이라는 영역이 있었고 이는 JVM이 클래스를 유지하는데 사용되었음
- java8 에서는 제거되고, MetaSpace라는 영역으로 대체됨
- PermGen space (permanent generation space)
    - java8 이전에는 클래스의 메타 정보가 permGen space에 저장됨
    - permGen space는 사이즈가 고정되어 있고, 동적으로 변경되지 않음
    - 기존에 정적이었던 이유는 permGen이 도입될 때, 동적 클래스 로드, 언로드가 없었기 때문임
    - 클래스가 로드되면 jvm이 종료될 때까지 메모리에 고정되어 영구적으로 존재했음
    - 요즘은 로드, 언로드되는 경우가 발생하므로, 바뀌어야 함
- MetaSpace
    - java8 에서는 permGen이 아닌 MetaSpace에 클래스의 메타데이터를 저장함
    - 사이즈 제약을 넘어서 동적으로 증가할 수 있음
    - garbage collection, auto-tuning, metadata의 de-allocation을 용이하게 함
    
함수형 프로그래밍의 장점?

java는 원래 객체 지향 언어라서, 함수형 프로그래밍이 불가능함
java8부터는 함수형 인터페이스, 람다 표현식을 추가해서 함수형 프로그래밍을 지원함

jvm (java virtual machine) 
- 자바와 운영체제 사이에 존재하며 자바가 플랫폼에 종속적이지 않을 수 있게 해주는 장치
- 가비지 컬렉터를 사용해 메모리 관리도 자동으로 수행하며, 레지스터 기반이 아닌 스택 기반으로 동작함


