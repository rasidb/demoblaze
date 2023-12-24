@demoblaze
Feature: demoblaze kayıt

  Scenario: demoblaze gir ve kayıt işlemlerini tamamla
    Given kullanıcı "https://demoblaze.com/" sitesine gider
    And sign up butonuna basar
    When kullanıcı "rasid58" ve "4342" belirleyerek kayıt işlemini tamamlar
    Then kullanıcı "rasid58" ve "4342" ile giriş yapabilmeli
    Then ekranda welcome yazısı görülmeli