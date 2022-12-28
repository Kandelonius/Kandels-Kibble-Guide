using KibbleBackend.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace KibbleBackend.Controllers
{

    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly UserContext userContext;

        public UserController(UserContext context)
        {
            this.userContext = context;
        }
        /* GET: api/<UserController>
         *
         * https://localhost:7285/api/User
         */
        [HttpGet]
        public async Task<ActionResult<IEnumerable<User>>> GetUsers()
        {
            return await userContext.Users.ToListAsync();
        }

        /* GET api/<UserController>/5
         * https://localhost:7285/api/User/1
         */
        [HttpGet("{id}")]
        public async Task<ActionResult<User>> GetUser(int id)
        {
            var user = await userContext.Users.FindAsync(id);
            if (user == null)
            {
                return NotFound();
            }
            return user;
        }

        /* POST api/<UserController>
         * https://localhost:7285/api/User
         * 
         * {
            "id": 2,
            "firstName": "Jack",
            "lastName": "Nahm",
            "hasCat": false,
            "hasDog": true
           }
         */
        [HttpPost]
        public async Task<ActionResult<User>> PostUser(User user)
        {
            userContext.Users.Add(user);
            await userContext.SaveChangesAsync();

            return CreatedAtAction("GetUser", new { id = user.Id }, user);
        }

        /* PUT api/<UserController>/2
         * https://localhost:7285/api/User/2
         * 
         * {
            "id": 2,
            "firstName": "Jack",
            "lastName": "Nahm",
            "hasCat": true,
            "hasDog": false
           }
         */
        [HttpPut("{id}")]
        public async Task<ActionResult<User>> PutUser(int id, User user)
        {
            if (id != user.Id)
            {
                return BadRequest();
            }
            userContext.Entry(user).State = EntityState.Modified;

            try
            {
                await userContext.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!UserExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }
            return user;
        }

        /* DELETE api/<UserController>/2
         * https://localhost:7285/api/User/2
         */
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteUser(int id)
        {
            var user = await userContext.Users.FindAsync(id);
            if (user == null)
            {
                return NotFound();
            }

            userContext.Users.Remove(user);
            await userContext.SaveChangesAsync();

            return NoContent();
        }

        private bool UserExists(int id)
        {
            return userContext.Users.Any(u => u.Id == id);
        }
    }
}
