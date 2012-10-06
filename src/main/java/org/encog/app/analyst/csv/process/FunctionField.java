package org.encog.app.analyst.csv.process;

import java.util.List;

import org.encog.parse.expression.ExpressionHolder;
import org.encog.parse.expression.ExpressionTreeElement;
import org.encog.parse.expression.ExpressionTreeFunction;
import org.encog.parse.expression.expvalue.ExpressionValue;

public class FunctionField extends ExpressionTreeFunction {
	
	private ProcessExtension extension;

	public FunctionField(ProcessExtension theExtension, ExpressionHolder theOwner, List<ExpressionTreeElement> theArgs) {
		super(theOwner, "field", theArgs);
		this.extension = theExtension;
	}

	@Override
	public ExpressionValue evaluate() {
		String fieldName = this.getArgs().get(0).evaluate().toStringValue();
		int fieldIndex = (int)this.getArgs().get(1).evaluate().toFloatValue()+this.extension.getBackwardWindowSize();
		String value = this.extension.getField(fieldName,fieldIndex);
		return new ExpressionValue(value);
	}

}
