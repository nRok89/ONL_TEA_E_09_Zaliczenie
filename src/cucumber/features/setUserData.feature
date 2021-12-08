Feature: Set User Data

  Scenario Outline: wpisanie danych uzytkownika na stronie mystore-testlab.coderslab.pl
    Given przegladarka otwarta na stronie mystore-testlab.coderslab.pl
    When zalogowanie uzytkownika na portalu na podajac email <email> i haslo <password>
    Then przejscie do zakładki Address i wypisanie danych <alias> "<address>" <city> <code> <phone> "<country>"
    And wyświetlenie i potwierdzenie zapisania danych <alias> "<address>" <city> <code> <phone> "<country>"
    When usuniecie danych z konta uzytkownika
    Then sprawdzenie czy dane zostaly usuniete
    Examples:
      | email                  | password   | alias | address       | city     | code    | phone        | country        |
      | wodowanie.jan123@wp.pl | Haslo1234* | Pike  | Portobello 13 | London   | W11-2ED | 442079089696 | United Kingdom |

