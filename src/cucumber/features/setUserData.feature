Feature: Set User Data

  Scenario Outline: wpisanie danych uzytkownika na stronie mystore-testlab.coderslab.pl
    Given przegladarka otwarta na stronie mystore-testlab.coderslab.pl
    When zalogowanie uzytkownika na portalu na podajac email <email> i haslo <password>
    Then przejscie do zakładki Address i wypisanie danych <alias> <address> <city> <code> <phone>
    And wyświetlenie i potwierdzenie zapisania danych <alias> <address> <city> <code> <phone>
    When usuniecie danych z konta uzytkownika
    Then sprawdzenie usunięcia danych
    Examples:
      | email                  | password   | alias | address    | code    | city   | phone        |
      | wodowanie.jan123@wp.pl | Haslo1234* | Pike  | Portobello | W11-2ED | London | 442079089696 |

