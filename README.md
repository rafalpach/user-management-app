# User Management Application API
## Show all users
__url:__    /users  
__method:__    GET

## Show users by optional parameters
__url:__				/usersby  
__method:__			GET  
__URL params (optional):__  
id=[int]  
name=[string]  
surname=[string]  
grade=[int]  
salary=[int]  
__example:__  
/usersby?name=Jan&grade=5

## Show specific user by ID  
__url:__				/user/:id  
__method:__			GET  


## Delete specific user  
__url:__				/user/:id  
__method:__			DELETE  

## Add new user  
__url:__			/user  
__method:__	POST  
__body params:__  
{  
"name": [string],  
"surname": [string],  
"grade": [int],  
"salary": [int]  
}

## Modify specific user  
__url:__		/user/:id  
__method:__			PUT  
__body params (optional):__  
{  
"name": [string],  
"surname": [string],  
"grade": [int],  
"salary": [int]  
}
