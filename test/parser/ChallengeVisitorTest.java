package parser;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import bs.BeanShell;
import bsh.EvalError;

public class ChallengeVisitorTest {

	@Test 
	public void test_visit_inputName() throws FileNotFoundException, EvalError{
		BeanShell bs = new BeanShell("TestChallenge");
		bs.initInterpreter();
		File tempFile = new File("");
		String filePath = tempFile.getAbsolutePath() + "/src/challenges/TestChallenge.java";
		CompilationUnit cu = JavaParser.parse(bs.readFile(filePath));
		ChallengeVisitor visitor = new ChallengeVisitor(bs.interpreter);
		visitor.visit(cu, null);
		assertEquals("input", visitor.inputName);
	}
	@Test 
	public void test_visit_override() throws FileNotFoundException, EvalError{
		BeanShell bs = new BeanShell("TestChallenge");
		bs.initInterpreter();
		File tempFile = new File("");
		String filePath = tempFile.getAbsolutePath() + "/src/challenges/TestChallenge.java";
		
		CompilationUnit cu = JavaParser.parse(bs.readFile(filePath));

		ChallengeVisitor visitor = new ChallengeVisitor(bs.interpreter);
		visitor.visit(cu, null);
		assertTrue(visitor.challengeMethod.contains("@Override"));
	}
	@Test 
	public void test_visit_Method() throws FileNotFoundException, EvalError{
		BeanShell bs = new BeanShell("TestChallenge");
		bs.initInterpreter();
		File tempFile = new File("");
		String filePath = tempFile.getAbsolutePath() + "/src/challenges/TestChallenge.java";
		
		CompilationUnit cu = JavaParser.parse(bs.readFile(filePath));

		ChallengeVisitor visitor = new ChallengeVisitor(bs.interpreter);
		visitor.visit(cu, null);
		assertTrue(visitor.challengeMethod.contains("public void challenge(Integer input)"));
	}
	@Test 
	public void test_visit_variable() throws FileNotFoundException, EvalError{
		BeanShell bs = new BeanShell("TestChallenge");
		bs.initInterpreter();
		File tempFile = new File("");
		String filePath = tempFile.getAbsolutePath() + "/src/challenges/TestChallenge.java";
		
		CompilationUnit cu = JavaParser.parse(bs.readFile(filePath));

		ChallengeVisitor visitor = new ChallengeVisitor(bs.interpreter);
		visitor.visit(cu, null);
		assertTrue(visitor.challengeMethod.contains("int hello = input * 2;"));
	}
	@Test 
	public void test_visit_size_Node_List() throws FileNotFoundException, EvalError{
		BeanShell bs = new BeanShell("TestChallenge");
		bs.initInterpreter();
		File tempFile = new File("");
		String filePath = tempFile.getAbsolutePath() + "/src/challenges/TestChallenge.java";
		
		CompilationUnit cu = JavaParser.parse(bs.readFile(filePath));

		ChallengeVisitor visitor = new ChallengeVisitor(bs.interpreter);
		visitor.visit(cu, null);
		assertEquals(2, visitor.nodeList.size());
	}
	
	@Test
	public void test_verif_first_element_List() throws FileNotFoundException, EvalError{
		BeanShell bs = new BeanShell("TestChallenge");
		bs.initInterpreter();
		File tempFile = new File("");
		String filePath = tempFile.getAbsolutePath() + "/src/challenges/TestChallenge.java";
		
		CompilationUnit cu = JavaParser.parse(bs.readFile(filePath));

		ChallengeVisitor visitor = new ChallengeVisitor(bs.interpreter);
		visitor.visit(cu, null);
		assertEquals("int hello = input * 2;", visitor.nodeList.get(0).toString());
		
	}

}
