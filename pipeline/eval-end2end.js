const cheerio = require('cheerio');
const fs = require('fs');
const path = require('path');

const MINIMUM_SCORES = {
    'High': 0,
    'Medium': 40,
    'Low': Infinity,
    'Informational': Infinity
}

const reportOf = (fileName = '') => {
    const fileURL = path.resolve(__dirname, `../scan-results/${fileName}`);
    const p = fs.readFileSync(fileURL, { encoding: 'utf8' });
    const $ = cheerio.load(p);
    const report = {};
    $('table.summary tr td a[href]').each((_, el) => {
        const key = el.children[0].data;
        const value = el.parent.nextSibling.children[0].data;
        report[key] = +value;
    });
    console.log(fileName);
    console.table(report);
    return report;
}

const validateReport = ({ High, Medium, Low, Informational }) => {
    if (High > MINIMUM_SCORES.High) {
        console.error('High is:', High, 'when it should be less than:', MINIMUM_SCORES.High);
        throw new Error('NOT_VALID_SCORE');
    } else if (Medium > MINIMUM_SCORES.Medium) {
        console.error('Medium is:', Medium, 'when it should be less than:', MINIMUM_SCORES.Medium);
        throw new Error('NOT_VALID_SCORE');
    } else if (Low > MINIMUM_SCORES.Low) {
        console.error('Low is:', Low, 'when it should be less than:', MINIMUM_SCORES.Low);
        throw new Error('NOT_VALID_SCORE');
    } else if (Informational > MINIMUM_SCORES.Informational) {
        console.error('Informational is:', Informational, 'when it should be less than:', MINIMUM_SCORES.Informational);
        throw new Error('NOT_VALID_SCORE');
    } else {
        console.log('All good. You shall pass');
        console.log();
    }
}

const reportFiles = () => {
    return fs.readdirSync(path.resolve(__dirname, `../scan-results`))
}
reportFiles().forEach(file => {
    const r = reportOf(file);
    validateReport(r);
});