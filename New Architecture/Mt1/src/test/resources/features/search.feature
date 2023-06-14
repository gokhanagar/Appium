@Sahibinden
Feature:Sahibinden.com

  @Ornek1
  Scenario: search daire in IStanbul
    Given user should see the Home Page
    When user taps "Emlak" on Home Page
    When user taps "Konut" on Categories Page
    When user taps "Satılık" on Categories Page
    When user taps "Daire" on Categories Page
    Then should see Results on Result Page

  @Ornek2
  Scenario: check filters
    Given user should see the Home Page
    When user taps "Vasıta" on Home Page
    When user close alert on Categories Page
    When user taps "Otomobil" on Categories Page
    When user taps "Mazda" on Categories Page
    When user taps "Lantis" on Categories Page
    When user taps "1.8" on Categories Page
    When taps devam et Result Page
    When taps filters on Result Page
    When taps "Fiyat" on Filters Page
    When sendkeys Max Price "200000" on Filters Page
    When taps "TAMAM" button on Filters Page
    When taps Show Results Button on Filters Page
    When taps order on Results Page
    When select "Fiyata göre (Önce en yüksek)" on Order Page
    Then should see first car price lower than of equals "200.000" on Results Page


