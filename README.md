# APIDemo

This application is an implementation of <b>/tasks</b> and <b>/todo</b> from https://join.autogeneral.com.au/swagger-ui/?url=/swagger.json#/ and 
deployed on Heroku. You can call the implemented api methodes throuh a rest clien (like Postman).   
There is an API call for validating brackets in <b>/task</b> endpoint:

<b>GET   /tasks/validateBrackets :</b><br/>
      <pre>url: http://apidemoautogeneral.herokuapp.com/api/tasks/validateBrackets <br/> 
      parameter: name --> input,   description --> Input string (min length 1 and max length 50)<br/>
</pre><br/>

API endpoints for <b>/items/todo</b> are: 

<b>POST   /items/todo :</b><br/>
      <pre>url: http://apidemoautogeneral.herokuapp.com/api/items/todo <br/> 
      parameter: name --> body,   description --> {"text": "test text"}<br/>
</pre><br/>

<b>GET   /items/todo{id} :</b><br/>
      <pre>url: http://apidemoautogeneral.herokuapp.com/api/items/todo/{id} <br/> 
      parameter: name --> id,   description --> id<br/>
</pre><br/>

<b>PATCH /items/todo{id} :</b><br/>
      <pre>url: http://apidemoautogeneral.herokuapp.com/api/items/todo/{id} <br/> 
      parameter: name --> id,   description --> id<br/>
      parameter: name --> body,   description --> {"text": "test text", "isCompleted": true/false}<br/>
</pre><br/>
