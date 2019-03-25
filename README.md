# APIDemo

This application is an implementation of <b>/tasks</b> and <b>/todo</b> from https://join.autogeneral.com.au/swagger-ui/?url=/swagger.json#/ and 
deployed on Heroku. You can call the implemented api methodes throuh a rest clien (like Postman).   
To access the api please use following api calls:

<b>GET   /tasks/validateBrackets :</b><br/>
      <pre>url: http://apidemoautogeneral.herokuapp.com/api/tasks/validateBrackets <br/> 
      param: input <br/>
</pre><br/>

<b>POST   /items/todo :</b><br/>
      <pre>url: http://apidemoautogeneral.herokuapp.com/api/items/todo <br/> 
      param: text <br/>
</pre><br/>

<b>GET   /items/todo{id} :</b><br/>
      <pre>url: http://apidemoautogeneral.herokuapp.com/api/items/todo/{id} <br/> 
      param: id <br/>
</pre><br/>

<b>PATCH /items/todo{id} :</b><br/>
      <pre>url: http://apidemoautogeneral.herokuapp.com/api/items/todo/{id} <br/> 
      param: id <br/>
</pre><br/>
