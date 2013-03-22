package hello;

import com.techempower.gemini.form.*;
import com.techempower.gemini.*;

/**
 * A specialization of Gemini's Form for GeminiHello.
 *   <p>
 * By convention, all forms used by this application will use method="POST"
 * and POST is required for validation.  A hidden nonce element is added
 * to every form to help prevent cross-site request forgery.
 *
 * @see com.techempower.gemini.form.Form
 *
 * Development history:
 *   2012-04-19 - mh - Created
 *
 * @author mhixson
 */
public class GhForm
     extends Form
{

	//
	// Member methods.
	//

  /**
   * Creates a new form.
   *
   * @param context The current context.
   * @param action The URL to submit to.
   * @param formName A name to give the form in case automatic naming 
   *                 (generated by the context's command) is not 
   *                 desirable. 
   */
  public GhForm(Context context, String action, String formName)
  {
    super(context.getApplication(), formName, action, Form.POST);
        
    // Require that the method used to submit the form be POST.  This
    // is done as a counter-measure against cross-site request forgery.
    addValidator(new FormPostRequired());
    
    // Add a nonce for the form.  This is also an anti-CSRF measure.
    addElement(new FormNonce("nonce", context));
  }

  /**
   * Creates a new form.  Names the form based on the current command.
   *
   * @param context The current context.
   * @param action The URL to submit to.
   */
  public GhForm(Context context, String action)
  {
    this(context, action, null);
  }

  @Override
  protected <C extends Context> void onValidlySubmitted(C arg0)
  {
    // Does nothing.    
  }

}   // End GhForm.
