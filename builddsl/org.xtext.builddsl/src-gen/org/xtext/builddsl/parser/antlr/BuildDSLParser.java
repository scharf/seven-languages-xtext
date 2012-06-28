/*
* generated by Xtext
*/
package org.xtext.builddsl.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.xtext.builddsl.services.BuildDSLGrammarAccess;

public class BuildDSLParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private BuildDSLGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.xtext.builddsl.parser.antlr.internal.InternalBuildDSLParser createParser(XtextTokenStream stream) {
		return new org.xtext.builddsl.parser.antlr.internal.InternalBuildDSLParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "BuildFile";
	}
	
	public BuildDSLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(BuildDSLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
