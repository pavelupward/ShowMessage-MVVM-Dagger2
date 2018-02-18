package by.oz.android.ui.checkout.cart.stock.models;

import android.text.TextUtils;
import by.oz.android.data.network.models.response.common.OzResponse;
public class ErrorModel {
    protected boolean isServerError;

    protected boolean isNetworkError;

    protected boolean isError;

    protected boolean isVersionError;

    protected String errorText;

    protected boolean isMaintenanceError;

    protected String notifyMessage;

    protected boolean isAuthError;

    protected boolean isAuthClean;

    protected boolean isNotFoundError;

    public ErrorModel() {
        this.isServerError = false;
        this.isNetworkError = false;
        this.isError = false;
        this.isAuthError = false;
    }

    public ErrorModel(boolean isServerError, boolean isNetworkError) {
        this.isServerError = isServerError;
        this.isNetworkError = isNetworkError;
    }

    public ErrorModel(boolean isServerError, boolean isNetworkError, boolean isError) {
        this.isServerError = isServerError;
        this.isNetworkError = isNetworkError;
        this.isError = isError;
    }

    public ErrorModel(boolean isServerError, boolean isNetworkError, boolean isError, String errorText) {
        this.isServerError = isServerError;
        this.isNetworkError = isNetworkError;
        this.isError = isError;
        this.errorText = errorText;
    }

    public boolean isAnyError() {
        return
                isServerError ||
                        isNetworkError ||
                        isNotFoundError() ||
                        isAuthError ||
                        isMaintenanceError ||
                        isError;
    }

    public boolean isServerError() {
        return isServerError;
    }

    public void setServerError(boolean serverError) {
        isServerError = serverError;
    }

    public boolean isNetworkError() {
        return isNetworkError;
    }

    public void setNetworkError(boolean networkError) {
        isNetworkError = networkError;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public boolean isVersionError() {
        return isVersionError;
    }

    public void setVersionError(boolean versionError) {
        isVersionError = versionError;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public boolean isMaintenanceError() {
        return isMaintenanceError;
    }

    public void setMaintenanceError(boolean maintenanceError) {
        isMaintenanceError = maintenanceError;
    }

    public String getNotifyMessage() {
        return notifyMessage;
    }

    public void setNotifyMessage(String notifyMessage) {
        this.notifyMessage = notifyMessage;
    }

    public boolean isAuthError() {
        return isAuthError;
    }

    public void setAuthError(boolean authError) {
        isAuthError = authError;
    }

    public boolean isAuthClean() {
        return isAuthClean;
    }

    public void setAuthClean(boolean authClean) {
        isAuthClean = authClean;
    }

    public boolean isNotFoundError() {
        return isNotFoundError;
    }

    public void setNotFoundError(boolean notFoundError) {
        isNotFoundError = notFoundError;
    }

    public <T1, T2> void setErrors(OzResponse<T1, T2> responseOzResponse) {
        setServerError(responseOzResponse.isServerError);
        setNetworkError(responseOzResponse.isNetworkError);
        setNotFoundError(responseOzResponse.isNotFoundError);
        setAuthError(responseOzResponse.isAuthError);
        setMaintenanceError(responseOzResponse.isMaintenanceError);
        if(!TextUtils.isEmpty(responseOzResponse.getErrorText())){
            setErrorText(responseOzResponse.getErrorText());
    }
    }

    public void setErrors(ErrorModel responseOzResponse) {
        setServerError(responseOzResponse.isServerError);
        setNetworkError(responseOzResponse.isNetworkError);
        setNotFoundError(responseOzResponse.isNotFoundError);
        setAuthError(responseOzResponse.isAuthError);
        setMaintenanceError(responseOzResponse.isMaintenanceError);
        if(!TextUtils.isEmpty(responseOzResponse.getErrorText())){
            setErrorText(responseOzResponse.getErrorText());
        }
    }
}
