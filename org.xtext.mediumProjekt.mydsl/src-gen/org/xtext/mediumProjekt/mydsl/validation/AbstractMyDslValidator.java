/*
 * generated by Xtext 2.35.0
 */
package org.xtext.mediumProjekt.mydsl.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractMyDslValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(org.xtext.mediumProjekt.mydsl.myDsl.MyDslPackage.eINSTANCE);
		return result;
	}
}
