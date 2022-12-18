Feature: API Demos Test

  Scenario: Text box data gonderme
    Given App yuklensin
    And kullanici ana ekranda
    And kullanici API Demos butonuna tikladi
    Then Kullanici API Demos ekraninda
    And kullanici Preference butonuna tikladi
    Then kullanici Preference ekraninda
    And kullanici Preference depenencies tikladi
    And kullanici Wifi check box secmis olacak
    And kullanici Wifi Settings tikladi
    Then Wifi setting popup geldi
    And kullanici "text" yazdi
    And kullanici ok butonuna tikladi
