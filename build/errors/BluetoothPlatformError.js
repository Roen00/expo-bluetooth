import BluetoothError from './BluetoothError';
export default class BluetoothPlatformError extends BluetoothError {
    constructor({ name, message, stack, code, invokedMethod }) {
        super({ name, code, message, stack });
        this.invokedMethod = invokedMethod;
    }
    toJSON() {
        const json = super.toJSON();
        return {
            ...json,
            message: `${this.invokedMethod}() ${json.message}`,
            stack: undefined,
            invokedMethod: this.invokedMethod,
        };
    }
}
//# sourceMappingURL=BluetoothPlatformError.js.map