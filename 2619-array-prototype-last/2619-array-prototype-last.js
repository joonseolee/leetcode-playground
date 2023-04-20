Array.prototype.last = function() {
    const length = this.length;
    if (!length) {
        return -1;
    }
    
    return this[this.length - 1];
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */