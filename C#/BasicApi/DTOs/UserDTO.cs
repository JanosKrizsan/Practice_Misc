using AuthApiPractice.Models;

namespace ApiPractice.DTOs
{
    public class UserDTO
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string HashedPass { get; set; }
        public string ContentPreference { get; set; }

    }
}
