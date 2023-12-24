@demoblaze
Feature: demoblaze ui testleri
  Scenario: kullanıcı ürün satın alır
    Given Kullanıcı giriş yapar
    And sepete ürün ekler
    And "Place Order" butonuna basarak sipariş için gerekli formu doldurur
    Then siparis tamamlanmıs olmalı
