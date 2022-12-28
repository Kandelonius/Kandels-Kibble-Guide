namespace KibbleBackend.Models
{
    public class User
    {
        public int Id { get; set; } 
        public string firstName { get; set; }
        public string lastName { get; set; }
        public bool hasCat { get; set; }
        public bool hasDog { get; set; }
    }
}
