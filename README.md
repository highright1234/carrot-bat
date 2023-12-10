![img.png](img.png)
# carrot-bat
생강이 도박 예측을 위한 당근빠따

## 아이디어 유도
java.lang.Random의 기본 인스턴스 생성에 seed는 자바17기준으로  
uniquifier와 nanotime에 의존함  
-> 그러면 uniquifier와 nanotime만 알면 seed 찾을수 있네?  
--> 실행해볼까?

## 작동법
생강이의 도박은 Collections.shuffle을 이용하고  
처음 shuffle이 작동될때 r(java.util.Random)이 초기화된다  
그러니 생강이가 켜지고 처음 도박 할때 유저가 메시지 보낸시간, 답장된 시간 사이를 찍으면 된다  
-> Brute force (노가다작업)  
대략 2초 반응이라면 20억번 정도?  

uniquifier는 random 생성될때마다 바뀐다.  
근데 많은곳에서 Random을 사용한다.  
이것도 노가다로 여러번 uniquifier 바뀔때마다의 상황 계산 필요  
-> Brute force (또 노가다)  
대략 자바에서 Random이 사용되는게 2n개 정도니 30으로 함.  

그러면 실행할때 필요한 값:
- 도박결과 샘플
- 생강이 켜지고 플레이어가 처음 도박했을때 시간과 생강이의 답장 시간
- uniquifier 몇개까지 계산할지 갯수

### 결과
실패, 이유는 ㅁ?ㄹ

### 단점
속도가 너무 느렸음  
하지만 Collections.shuffle 시스템에 의존해서 해결법은 내 수준으론 모름  

## 참고자료
- [GamblingCommand.java](https://github.com/ssyuk/imgin.ger/blob/master/src/main/java/me/syuk/saenggang/commands/game/GamblingCommand.java)
- [java.util.Random](https://github.com/openjdk/jdk17/blob/4afbcaf55383ec2f5da53282a1547bac3d099e9d/src/java.base/share/classes/java/util/Random.java)