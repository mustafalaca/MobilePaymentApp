from flask import jsonify, Blueprint, request, abort
from flask_jwt_extended import jwt_required
from backend.api.models.plate import Plate

bp = Blueprint("plate", __name__)


@bp.route('/add_plate', methods=['POST'])  # REQUEST CONTENT: phone_number, customer_license_plate
@jwt_required()
def add_plates_view():
    data = request.get_json()
    plate_obj = Plate(**data)
    response = plate_obj.add_plate()
    if response is True:
        return jsonify(200)
    return jsonify(400)


@bp.route('/get_plate', methods=['POST'])  # REQUEST CONTENT: phone_number
@jwt_required()
def get_all_plates():
    data = request.get_json()
    plate_obj = Plate(**data)
    response = plate_obj.get_plates()
    return jsonify(response)


@bp.route('/plate_payment_history', methods=['POST'])  # REQUEST CONTENT: phone_number, customer_license_plate
@jwt_required()
def plate_payment_history():
    data = request.get_json()
    plate_obj = Plate(**data)
    response = plate_obj.payment_history()
    return jsonify(response)


@bp.route('/delete_plate', methods=['POST'])  # REQUEST CONTENT: phone_number, customer_license_plate
@jwt_required()
def delete_plate():
    data = request.get_json()
    plate_obj = Plate(**data)
    response = plate_obj.del_plate()
    if response is True:
        return jsonify(200)
    return abort(400)
