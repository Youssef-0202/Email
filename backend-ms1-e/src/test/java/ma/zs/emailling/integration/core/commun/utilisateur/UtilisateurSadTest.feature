Feature: Utilisateur

  Background:
    #* call read('karate-config.js')
    #* call read('db_cleaner.js')

    * url utilisateurUrl
    * header Content-Type = 'application/json'

    * def postBody = read('UtilisateurSave.json')
    * def FindAllSchema = read('UtilisateurSchema.json')
    * def uuid = function() { return '' + java.util.UUID.randomUUID(); }
    * postBody.username = uuid()

  @duplicate
  Scenario Outline: POST Utilisateur Twice with same username - expect <responseCode> as response code
    * postBody.code = uniqueId
    * def count = db.readValue('select count(*) FROM item.utilisateur')

    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * request postBody
    * method POST
    * status <responseCode>
    * eval if(__num==1 && count != db.readValue('select count(*) FROM utilisateur')) karate.fail("utilisateur count values in DB are different")

    Examples:
      | responseCode |
      | 201          |
      | 226          |

  @getByIdNotFound
  Scenario: Fail - GetByID Not Found
    * path 'id', 99999999
    * header Authorization = 'Bearer ' + adminToken
    * method GET
    * status 404
    * match response.length == 0


  @saveWithoutBody
  Scenario: Fail - POST Utilisateur without Body
    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method POST
    * status 400
    * match response.error == "Bad Request"


  @saveWithoutAuthorization
  Scenario: Fail - POST Utilisateur without Authorization
    * path ''
    * header Authorization = 'Bearer unvalid'
    * request postBody
    * method POST
    * status 401


  @saveWithPatchMethod
  Scenario: Fail - Save Utilisateur with method PATCH
    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method PATCH
    * status 405
    * match response.error == "Method Not Allowed"
