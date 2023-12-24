@demoblaze
Feature: demoblaze testleri
  Scenario: kullanıcı sepete ürün ekler ve sepetten geri siler
    And kullanıcı giriş yapar
    And anasayfada bulunan telefona tıklar ve sepete ekler
    Then "Product added." mesajı ekranda görülmeli
    And kullanıcı sepete gider ve ürünü sepetten siler
    Then ürün sepetten kaldırılmış olmalı
