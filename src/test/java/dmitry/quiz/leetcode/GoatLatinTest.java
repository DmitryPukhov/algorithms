package dmitry.quiz.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoatLatinTest {
    GoatLatin alg = new GoatLatin();
    @Test
    void toGoatLatin_words() {
        assertEquals("applemaa", alg.toGoatLatin("apple"));
        assertEquals("oatgmaa", alg.toGoatLatin("goat"));
        assertEquals("",  alg.toGoatLatin(""));
    }
    @Test
    void toGoatLatin_sentences() {
        assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa" , alg.toGoatLatin("I speak Goat Latin"));
    }

    @Test
    void toGoatLatin_uppercase() {
        assertEquals("Eachmaa ordwmaaa onsistscmaaaa ofmaaaaa owercaselmaaaaaa andmaaaaaaa uppercasemaaaaaaaa etterslmaaaaaaaaa onlymaaaaaaaaaa", alg.toGoatLatin("Each word consists of lowercase and uppercase letters only"));
    }

}