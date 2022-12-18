Feature: Api Demos Switches
  Scenario:Switch Test
    Given App yuklensin
    When kullanici ana ekranda
    And kullanici API Demos butonuna tikladi
    Then Kullanici API Demos ekraninda
    And kullanici Preference butonuna tikladi
    Then kullanici Preference ekraninda
    And kullanici Switches tikladi

  Scenario: Switch test
    Given App yuklensin
    When kullanici ana ekranda
    And kullanici API Demos butonuna tikladi
    Then Kullanici API Demos ekraninda
    And kullanici Preference butonuna tikladi
    Then kullanici Preference ekraninda
    And kullanici Switches tikladi
    And kullanici check box tikladi
    And kullanici switch butonuna tikladi
    Then screenshot al

    Scenario: Switch button checks
      Given App yuklensin
      When kullanici ana ekranda
      And kullanici API Demos butonuna tikladi
      Then Kullanici API Demos ekraninda
      And kullanici Preference butonuna tikladi
      Then kullanici Preference ekraninda
      And kullanici Switches tikladi
      And check box secili olmali
      And ilk swicth butonu kapali
      And ikinci switch butonu acik
      Then screenshot al









