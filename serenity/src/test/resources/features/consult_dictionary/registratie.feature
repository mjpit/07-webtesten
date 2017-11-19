Feature:
  Om mee te kunnen doen aan de cursus als cursist
  Moet ik me als cursist kunnen registeren


  Scenario: Registreren met gebruikersnaam en email
    Given the gebruiker is op de registreer pagina
    When de gebruiker gebrukersnaam en email invoerd
    Then dan komt hij op de activeer pagina

  Scenario: Looking up the definition of 'pear'
    Given the user is on the Wikionary home page
    When the user looks up the definition of the word 'pear'
    Then they should see the definition 'An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.'
