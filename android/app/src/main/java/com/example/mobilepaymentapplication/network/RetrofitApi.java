package com.example.mobilepaymentapplication.network;

import com.example.mobilepaymentapplication.models.PhoneNumberModel;
import com.example.mobilepaymentapplication.models.RegistrationRequest;
import com.example.mobilepaymentapplication.models.TokenAuthenticationModel;
import com.example.mobilepaymentapplication.responses.GetTokenModel;
import com.example.mobilepaymentapplication.responses.WalletModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitApi {


    @POST("register")
    Call<ResponseBody> registrationRequest(@Body RegistrationRequest registrationRequest);

    @POST("login")
    Call<GetTokenModel> tokenAuthenticationRequest(@Body TokenAuthenticationModel tokenAuthenticationModal);
//
//    @POST("add_plate")
//    Call<ResponseBody> postPlate(@Body PlateNewModel phone);
//
//    @POST("get_plate")
//    Call<List<String>>getPlates(@Body PostPhoneNumberModel plate);
//
//    @POST("payment_list")
//    Call<PaymentListModelNew> postMobileWithPlate(@Body PaymentListModelNew modal);
//
//
//    @POST("payment")
//    Call<WalletModelResponse> postPaymentInformationRequest(@Body PaymentDataModel paymentDataModel);
//
    @POST("get_wallet")
    Call<WalletModel> getAllWalletData(@Body PhoneNumberModel phoneNumberModel);
//
//    @PATCH("update_password")
//    Call<ResponseBody> changePassword(@Body ChangePasswordModel changePasswordModel);
//
//    @POST("delete_plate")
//    Call<ResponseBody> deletePlate(@Body PlateNewModel plateNewModel);
//
//    @PATCH("deposit_money")
//    Call<WalletModelResponse> updateTl(@Body UpdateTlModel phone);
//
//    @PATCH("exchange")
//    Call<WalletModelResponse> exchange(@Body ExchangeTlModel phone);
//
//    @POST("plate_payment_history")
//    Call<PaymentHistoryResponse>  getPlatePaymentHistory(@Body PlateNewModel plateNewModel);


}
