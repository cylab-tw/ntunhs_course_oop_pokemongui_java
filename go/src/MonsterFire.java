public class MonsterFire extends Monster 
{
    public int MonsterType =1;
    MonsterFire() 
    {
        HP = 100;
        Attack = 70;
        Defense = 5;
        ID = "001";
        Name = "Player";
    }
    
    int Defend(Monster object) 
    {
        int Brandom = (int) (Math.random() * (10 - 1 + 1) + 1);
        int result = 0;
        
        if (Brandom == 10) // 10% x4
        {
            object.Defense *= 4;
            result = 1;
        } 
        else if (Brandom >= 8 && Brandom <= 9) // 30% x2
        {
            object.Defense *= 2;
            result = 1;
        } 
        else if (Brandom >= 4 && Brandom <= 7) // 30% x1.5
        {
            object.Defense *= 1.5;
            result = 1;
        } 
        else if (Brandom >= 1 && Brandom <= 3) // 30% fail;
        {
            result = 2;
        }
        return result;
    }
}