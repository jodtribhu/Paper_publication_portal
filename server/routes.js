module.exports=(app)=>
{
    app.get('/fetchfaculties',FacultyFetchController.fetchfaculties)
}