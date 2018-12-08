@borrowing @ui
Feature: Form validations for calculating borrowing power of customer
  In order to see correct borrowing power
  The customer must be enter the data correctly
  If data passes the validations, the calculated amount needs to be displayed
  Otherwise customer should get a clear error message on failure
  Also customer should be able to reset the values with single 'Start over' click

  Background:
    Given Customer is on "personal/home-loans/calculators-tools/much-borrow/"

  Scenario Outline: Test the 'start over' button page resets all the field
    When Customer works out how much he could borrow based on details
      | <app_type>          | <app_type>           |
      | dependents          | <dependants>         |
      | property_buying_for | <prop_buying_for>    |
      | income              | <income>             |
      | other_income        | <other_income>       |
      | living_expenses     | <living_expenses>    |
      | current_home_loan   | <current_home_loan>  |
      | other_loan_payments | <other_loan_payment> |
      | other_commitments   | <other_commitment>   |
      | credit_card_limit   | <cc_limit>           |

    But Chooses to start over again
    Then All the fields in form are reset
    Examples:
      | app_type | dependants | prop_buying_for          | income | other_income | living_expenses | current_home_loan | other_loan_payment | other_commitment | cc_limit |
      | Single   | 4          | buying a home to live in | 80000  | 10000        | 500             | 0                 | 100                | 0                | 10000    |
    #can add more example scenarios here to validate different combinations of data

  Scenario Outline: Test that no loan amount is proposed if customer fails to enter correct details
    When Customer works out how much he could borrow based on details
      | <fieldName> | <fieldValue> |

    Then Customer gets error message "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641."
    Examples:
      | fieldName       | fieldValue |
      | living_expenses | 1          |