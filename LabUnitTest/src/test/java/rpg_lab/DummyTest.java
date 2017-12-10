package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    private Dummy dummy;
    private Axe axe;


    @Before
    public void test(){
        Dummy dummy = new Dummy(10, 10);
        Axe axe = new Axe(5,5);
        axe.attack(dummy);
    }

    @Test
    public void getHealthTest() {
        //Assert
        Assert.assertEquals("Test for geting Dummy health", 4, dummy.getHealth());

    }

    @Test
    public void takeAttack() {


    }

    @Test
    public void giveExperience() {
    }

    @Test
    public void isDead() {
    }
}