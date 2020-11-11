
using ApiPractice.DTOs;

namespace AuthApiPractice.Models
{
    public class User : UserDTO
    {
        public bool IsAdmin { get; set; }
    }
}
