
Using the provided seed data, expand each endpoint below to see the output it generates.

- get all users
<details>
<summary>localhost:1982/users/users</summary>

'''JSON
[
    {
        "userid": 1,
        "username": "john",
        "primaryemail": "a@b.c"
    }
]
'''
</details>
- post a new user: sample input
<details>
<summary>localhost:1982/users/users</summary>

'''JSON
[
    {
        "username": "James",
        "password" : "Coffee123",
        "primaryemail": "a@b.c"
    }
]
'''
</details>