var db = connect("mongodb://root:pestillo@localhost:27017/admin");

db = db.getSiblingDB('taskOrganizer-images'); // we can not use "use" statement here to switch db

db.createUser(
    {
        user: "lo",
        pwd: "pestillo",
        roles: [ { role: "readWrite", db: "taskOrganizer-images"} ],
    }
)