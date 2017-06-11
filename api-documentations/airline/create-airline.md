**Create Airline**
----
  Create an airline

* **URL**

  /rs/airline/create

* **Method:**

  `POST`
  
*  **URL Params**

   None

* **Data Params**

  **Required:** `name=[string]`

* **Success Response:**

  * **Code:** 200
  
    **Content:** 
    ```
    {
        "id": 2,
        "name": "SkyTeam"
    }
    ```
 
* **Error Response:**

  * **Code:** 500 Server Error
  
    **Content:** `{ error : "Cannot create airline" }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/airline/create",
      dataType: "json",
      type : "POST",
      data: {"name": "SkyTeam"},
      success : function(r) {
        console.log(r);
      }
    });
  ```