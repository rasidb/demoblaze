@demoblaze
Feature: demoblaze testleri
  Scenario: kullanıcı birden fazla ürünü sepete ekler fiyatlarını doğrular ve satın alır
    Given kullanıcı giris yapar
    And birkaç ürünü sepete ekler
    Then ürün ekranıyla sepet fiyat toplamı aynı olmalı
    Then satın alma işlemini onaylar