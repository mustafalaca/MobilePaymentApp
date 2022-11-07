from flask import jsonify, Blueprint, request
from flask_jwt_extended import jwt_required
from ..models.payment import Payment
from ..models.wallet import Wallet

bp = Blueprint("payment", __name__)


@bp.route('/payment_list', methods=['POST'])
@jwt_required()
def get_payment():
    data = request.get_json()
    payment = Payment(**data)
    response_data = payment.get_to_pay()
    return jsonify({"payment": response_data})


@bp.route('/payment', methods=['POST'])
@jwt_required()
def pay():
    data = request.get_json()
    wallet = Wallet(**data)
    payment = Payment(**data)
    wallet_amount = wallet.check_wallet_amount()
    if float(wallet_amount) >= float(data['paid_amount']):
        transaction_response = payment.pay()
        if transaction_response is True:
            wallet_update = wallet.update_wallet_on_payment()
            delete_paid_payment = payment.delete_paid_payment()
            if delete_paid_payment is True:
                transaction_amount = data.pop('paid_amount')
                data['paid_amount'] = float(-transaction_amount)
                update_transaction_history = wallet.create_transaction_history(transaction_type='payment', **data)
                if update_transaction_history is True:
                    return jsonify(wallet_update)
        return jsonify({}), 400
    return jsonify(402)  # Insufficient balance
