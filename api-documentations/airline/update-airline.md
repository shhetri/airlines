**Update Airline**
----
  Update an airline

* **URL**

  /rs/airline/:id

* **Method:**

  `PUT`
  
*  **URL Params**

   **Required:** `id=[integer]`

* **Data Params**

  **Required:** `name=[string]`

* **Success Response:**

  * **Code:** 200
  * **Content:** 
    ```
    {
        "id": 2,
        "name": "SkyTeam"
    }
    ```
 
* **Error Response:**

  * **Code:** 500 Server Error
    **Content:** `{ error : "Update failed." }`
  
    OR
  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Airline with id :id doesn't exist." }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/airline/1",
      dataType: "json",
      type : "PUT",
      data: {"name": "SkyTeam"},
      success : function(r) {
        console.log(r);
      }
    });
  ```