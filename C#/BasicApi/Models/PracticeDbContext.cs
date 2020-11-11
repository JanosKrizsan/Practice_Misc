using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AuthApiPractice.Models
{
    public class PracticeDbContext : DbContext
    {
        public DbSet<User> Users { get; set; }
        public PracticeDbContext(DbContextOptions<PracticeDbContext> options) : base(options)
        {

        }

    }
}
