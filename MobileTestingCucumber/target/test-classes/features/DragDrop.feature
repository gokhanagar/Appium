Feature: Api demos touch action

  Scenario: Drag and drop
    Given App yuklensin
    And kullanici ana ekranda
    And kullanici API Demos butonuna tikladi
    Then Kullanici API Demos ekraninda
    And kullanici Views butonuna tikladi
    Then kullanici Views ekraninda
    And kullanici Drag and Drop butonuna tikladi
    When kullanici birinci topu ikinci topun ustune birakti
    Then kullanici dorduncu top gorecek
    Then screenshot al

