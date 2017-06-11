**Find Airline By ID**
----
  Returns json data abour an airline

* **URL**

  /rs/airline/:id

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
   `id=[integer]`

* **Data Params**

  None

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

  * **Code:** 404 NOT FOUND
  
    **Content:** `{ error : "Airline with id :id doesn't exist." }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/airline/1",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```