# ⚾ 숫자 야구 게임

숫자 야구 게임은 컴퓨터가 임의로 만든 1부터 9까지의 **서로 다른 세 숫자**를 플레이어가 맞추는 게임입니다. 스트라이크와 볼 힌트를 활용하여 숫자를 추리하세요!

---

## 🚀 기능 요구 사항

- 컴퓨터는 1부터 9까지 **서로 다른 숫자** 3개를 무작위로 선택합니다.
- 사용자는 서로 다른 세 자리 수를 입력해 추리합니다.
- 컴퓨터는 다음 기준으로 힌트를 제공합니다:
    - **스트라이크**: 같은 수가 같은 자리에 있을 때
    - **볼**: 같은 수가 다른 자리에 있을 때
    - **낫싱**: 전혀 같은 수가 없을 때
- 사용자가 3개의 숫자를 모두 맞추면 게임이 종료됩니다.
- 게임이 종료되면 다음 옵션을 제공합니다:
    - `1`: 게임을 다시 시작
    - `2`: 게임 종료
- 잘못된 입력이 들어오면 `IllegalArgumentException` 예외가 발생하고, 게임은 종료됩니다.

---

## 🎮 게임 예시

```java
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : ...
```


---

## 🧪 입력 예외 처리

- 입력값이 `null`, 빈 문자열, 공백일 경우
- 숫자가 3자리가 아닐 경우
- 숫자에 `0` 또는 `10` 이상의 수가 포함될 경우
- 숫자가 중복된 경우
- 재시작 여부에 `1` 또는 `2` 외의 값을 입력한 경우

> 위 조건에 해당하면 `IllegalArgumentException`을 발생시키고 프로그램은 종료됩니다.

---

## 💡 개발 환경

- Java 17 이상
- Gradle 8.x
- 콘솔 기반 애플리케이션

---


