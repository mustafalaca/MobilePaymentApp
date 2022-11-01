from flask import jsonify, Blueprint, request
from flask_jwt_extended import jwt_required
from ..models.payment import Payment
from ..models.wallet import Wallet

bp = Blueprint("payment", __name__)


@bp.route('/payment_list', methods=['POST'])
@jwt_required()
def get_payment():
    data = request.get_json()
    response_data = Payment.get_to_pay(data['customer_license_plate'])
    return jsonify({"payment": response_data})


@bp.route('/payment', methods=['POST'])
@jwt_required()
def pay():
    data = request.get_json()
    wallet_amount = Wallet.check_wallet_amount(data['phone_number'])
    if float(wallet_amount) >= float(data['paid_amount']):
        transaction_response = Payment.pay(**data)
        if transaction_response is True:
            wallet_update = Wallet.update_wallet_on_payment(data['phone_number'], data['paid_amount'], data['liter'])
            delete_paid_payment = Payment.delete_paid_payment(data['customer_license_plate'])
            if delete_paid_payment is True:
                transaction_amount = data.pop('paid_amount')
                data['paid_amount'] = float(-transaction_amount)
                update_transaction_history = Wallet.create_transaction_history(transaction_type='payment', **data)
                if update_transaction_history is True:
                    return jsonify(wallet_update)
        return jsonify({}), 400
    return jsonify(402)  # Insufficient balance


@bp.route('/transaction_history', methods=['POST'])
@jwt_required()
def transaction_history():
    data = request.get_json()
    response_data = Wallet.get_transaction_history(data['phone_number'])
    return jsonify(response_data)
