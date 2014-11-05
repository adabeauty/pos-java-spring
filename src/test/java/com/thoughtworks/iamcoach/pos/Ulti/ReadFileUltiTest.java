package com.thoughtworks.iamcoach.pos.Ulti;

import com.thoughtworks.iamcoach.pos.util.ReadFileUlti;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ReadFileUltiTest {
    @Test
    public void can_the_text_file(){
        ReadFileUlti readFileUlti = new ReadFileUlti();
        String fileName = "cart.txt";
        assertThat(readFileUlti.readFile(fileName).size()).isEqualTo(9);
        assertThat(readFileUlti.readFile(fileName).get(1)).isEqualTo("ITEM000001");
    }
}
