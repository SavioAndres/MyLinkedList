/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylinkedlist;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author savio
 */
public class MyLinkedListTest {
    
    public MyLinkedListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of adicionar method, of class MyLinkedList.
     */
    @Test
    public void testAdicionar_GenericType() {
        System.out.println("adicionar");
        Object elemento = null;
        MyLinkedList instance = new MyLinkedList();
        instance.adicionar(elemento);
    }

    /**
     * Test of adicionarNoInicio method, of class MyLinkedList.
     */
    @Test
    public void testAdicionarNoInicio() {
        System.out.println("adicionarNoInicio");
        Object elemento = null;
        MyLinkedList instance = new MyLinkedList();
        instance.adicionarNoInicio(elemento);
    }

    /**
     * Test of adicionar method, of class MyLinkedList.
     */
    @Test
    public void testAdicionar_int_GenericType() {
        System.out.println("adicionar");
        int indice = 0;
        Object elemento = null;
        MyLinkedList instance = new MyLinkedList();
        instance.adicionar(indice, elemento);
    }

    /**
     * Test of adicionarTodos method, of class MyLinkedList.
     */
    @Test
    public void testAdicionarTodos() {
        System.out.println("adicionarTodos");
        String elementos = "o";
        MyLinkedList instance = new MyLinkedList();
        instance.adicionarTodos(elementos);
    }

    /**
     * Test of obter method, of class MyLinkedList.
     */
    @Test
    public void testObter() {
        System.out.println("obter");
        MyLinkedList instance = new MyLinkedList();
        instance.adicionar("o");
        Object result = instance.obter(0);
        assertEquals("o", result);
    }

    /**
     * Test of remover method, of class MyLinkedList.
     */
    @Test
    public void testRemover_int() {
        System.out.println("remover");
        MyLinkedList instance = new MyLinkedList();
        instance.adicionar("d");
        Object result = instance.remover(0);
        assertEquals("d", result);
    }

    /**
     * Test of remover method, of class MyLinkedList.
     */
    @Test
    public void testRemover_GenericType() {
        System.out.println("remover");
        Object elemento = null;
        MyLinkedList instance = new MyLinkedList();
        boolean expResult = false;
        boolean result = instance.remover(elemento);
        assertEquals(expResult, result);
    }

    /**
     * Test of limpar method, of class MyLinkedList.
     */
    @Test
    public void testLimpar() {
        System.out.println("limpar");
        MyLinkedList instance = new MyLinkedList();
        instance.limpar();
    }

    /**
     * Test of tamanho method, of class MyLinkedList.
     */
    @Test
    public void testTamanho() {
        System.out.println("tamanho");
        MyLinkedList instance = new MyLinkedList();
        assertEquals(0, instance.tamanho());
    }

    /**
     * Test of contem method, of class MyLinkedList.
     */
    @Test
    public void testContem() {
        System.out.println("contem");
        Object elemento = null;
        MyLinkedList instance = new MyLinkedList();
        boolean expResult = false;
        boolean result = instance.contem(elemento);
        assertEquals(expResult, result);
    }

    /**
     * Test of ehVazio method, of class MyLinkedList.
     */
    @Test
    public void testEhVazio() {
        System.out.println("ehVazio");
        MyLinkedList instance = new MyLinkedList();
        boolean expResult = true;
        boolean result = instance.ehVazio();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class MyLinkedList.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MyLinkedList instance = new MyLinkedList();
        String expResult = "[]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of iterator method, of class MyLinkedList.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        MyLinkedList instance = new MyLinkedList();
        instance.adicionar("q");
        Object result = instance.iterator().next();
        assertEquals("q", result);
    }
    
}
